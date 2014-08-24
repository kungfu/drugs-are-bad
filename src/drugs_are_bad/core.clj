(ns drugs-are-bad.core
  (:gen-class))

; Sorts a murder of dolls by their weight, ascending
(defn weight-sort [ds] 
  (sort-by #(:weight %) ds))

; Sorts a murder of dolls by their name, ascending
(defn name-sort [ds]
  (sort-by #(:name %) ds))

; Calculates the total value of a murder of dolls
(defn valsum [dolls] 
  (reduce + (map #(:value %) dolls)))

; Calculates the most valuable murder of dolls, given multiple.
(defn max-murder-of-dolls [murder]
  (last (sort-by valsum murder))) 

; Figures out how to best burden the mule, assuming the dolls are sorted by weight. 
; (Private because of the sorting assumption)
(defn- burden-sorted
  ([mw dolls] 
    (let [d (first dolls)
          dw (:weight d)]
      (if (and d (>= mw dw))
        (max-murder-of-dolls [
          (burden-sorted mw (rest dolls))
          (cons d (burden-sorted (- mw dw) (rest dolls)))])
        []))))

; Figures out how to best burden the mule, given a max weight and a murder of dolls
(defn burden [mw dolls]
  (burden-sorted mw (weight-sort dolls)))

