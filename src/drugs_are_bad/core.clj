(ns drugs-are-bad.core
  (:gen-class))


(defn weight-sort [ds] 
  (sort-by (fn [d] (:weight d)) ds))

(defn burden-sorted
  ([mw dolls] 
    (let [d (first dolls)
          dw (:weight d)]
      (if (and d (>= mw dw))
        (cons d (burden-sorted (- mw dw) (rest dolls)))
        []))))

(defn burden [mw dolls]
  (burden-sorted mw (weight-sort dolls)))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello world"))

