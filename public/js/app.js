/*jslint browser: true*/
/*global $, jQuery, alert, localStorage*/
/*jslint unparam: true, node: true */
(function ($) {
    "use strict";

    $(function () {
        var
            appendDollRow = function (name, weight, value) {
                var
                    i = $("#allDolls tr.doll-row").length,
                    row = $("<tr/>").addClass("doll-row doll-row-" + i);

                row.append($("<td/>")
                    .append($("<input type='text' class='doll-name' placeholder='Name'/>")
                        .attr({ name: "dollname" + i, value: name })));
                row.append($("<td/>")
                    .append($("<input type='number' class='doll-weight col-xs-4' placeholder='Weight'/>")
                        .attr({ name: "dollweight" + i, value: weight })));
                row.append($("<td/>")
                    .append($("<input type='number' class='doll-value col-xs-4' placeholder='Value'/>")
                        .attr({ name: "dollvalue" + i, value: value })));
                row.append($("<td/>")
                    .append($("<button class='btn btn-sm btn-danger delete-doll'>Delete</button>")
                        .data("doll-num", i)));

                $("#allDolls").append(row);

                return row;
            },

            addNewDollRow = function () {
                var row = appendDollRow();
                row.find("td:first input").focus();
            },

            getDolls = function () {
                var list = [];

                $("#allDolls tr.doll-row").each(function () {
                    var
                        $this = $(this),
                        doll = {
                            name: $this.find("input.doll-name").val(),
                            weight: $this.find("input.doll-weight").val(),
                            value: $this.find("input.doll-value").val()
                        };

                    if (doll.name || doll.weight || doll.value) {
                        list.push(doll);
                    }
                });

                return list;
            },

            save = function () {
                localStorage.maxWeight = $("#maxWeight").val();
                localStorage.dolls = JSON.stringify(getDolls());
            },

            isFormComplete = function () {
                var
                    dolls = getDolls(),
                    badDolls = false;

                if (!dolls || !dolls.length) {
                    return false;
                }

                $.each(dolls, function (i, doll) {
                    if (!doll.name || isNaN(doll.weight) || doll.weight <= 0 || isNaN(doll.value) || doll.value <= 0) {
                        badDolls = true;
                    }
                });

                if (badDolls) {
                    return false;
                }

                return $("#maxWeight").val() && !isNaN($("#maxWeight").val());
            },

            queryBurden = function () {
                var
                    status = $("#burdenStatus"),
                    output = $("#burdenResults");

                if (!isFormComplete()) {
                    status.text("Fill out the form. Then we'll talk.");
                    output.html("");
                    return;
                }

                $.post("/api/burden-with-drugs", {
                    maxWeight: $("#maxWeight").val() || 0,
                    dolls: getDolls()
                }).done(function (data) {
                    output.html("");

                    if (!data.result || !data.result.length) {
                        status.text("You can't carry shit.");
                    } else {
                        status.text("Here, take these drugs, errrr.... dolls");
                    }
                    $.each(data.result, function (i, doll) {
                        output.append("<strong>" + doll.name + "</strong> (weight: " + doll.weight + ", value: " + doll.value + ")<br/>");
                    });
                }).fail(function (err) {
                    status.html("Oops. Something went horribly wrong.");
                    output.text(JSON.stringify(err));
                });
            },

            loadLastDollState = function () {
                $("#maxWeight").val(localStorage.maxWeight);

                if (localStorage.dolls) {
                    var dolls;

                    try {
                        dolls = JSON.parse(localStorage.dolls);
                    } catch (ignore) {}

                    if (dolls) {
                        $.each(dolls, function (i, doll) {
                            appendDollRow(doll.name, doll.weight, doll.value);
                        });
                    }
                }

                queryBurden();
            };

        $("#addDoll").click(function (e) {
            e.preventDefault();
            e.stopPropagation();

            addNewDollRow();
        });

        $("body")
            .on("blur", "input", function () {
                save();
                queryBurden();
            });

        $("#allDolls")
            .on("click", "button.delete-doll", function (e) {
                e.preventDefault();
                e.stopPropagation();

                $("#allDolls tr.doll-row-" + $(this).data("doll-num")).remove();
                save();
                queryBurden();
            });

        loadLastDollState();
    });
}(jQuery));

