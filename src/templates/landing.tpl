<!DOCTYPE html>
<html>
  <!-- http://mustache.github.com/mustache.5.html -->
  <head>
    <!-- partial is just like copy and paste the template here -->
    {{>partials/header}}
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">{{sanitized-ns}}</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="mailto:chad@freakingawesome.net">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <h1>Mule Burden Calculator</h1>
      
      <label for="maxWeight">How much can you carry?</label>
      <input type="number" name="maxWeight" id="maxWeight" placeholder="Max weight"/>
      
      <table id="allDolls" class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>Doll Name</th>
            <th>Weight</th>
            <th>Value</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        </tbody>
      </table>

      <button id="addDoll" class="btn">
        Add Doll
      </button>

      <h2 id="burdenStatus"></h2>
      <div id="burdenResults"></div>
    </div>
    <script src="/static/js/lib/jquery-1.9.1.js"></script>
    <script src="/static/js/lib/bootstrap.js"></script>
    <script src="/static/js/app.js"></script>
  </body>
</html>
