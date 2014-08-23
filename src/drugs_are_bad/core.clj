(ns drugs-are-bad.core
  (:gen-class))


(defn burden
  ([mw dolls] 
    (if (empty? dolls) 
      [] 
      [(first dolls)])))





(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello world"))

