(ns drugs-are-bad.jsonhacks
  (:gen-class))

; The JPOST wasn't transcribing the post keys into a json array and I wasted
; too much time trying to figure out why. I'm brute forcing this for now...
(defn hack-get-dolls-from-post-data 
  ([data] (hack-get-dolls-from-post-data data 0))
  ([data i]
    (let [prefix (str "dolls[" i "]")
          n (data (str prefix "[name]"))]
      (if n
        (cons
          {:name n 
           :weight (Integer. (data (str prefix "[weight]")))
           :value (Integer. (data (str prefix "[value]")))}
          (hack-get-dolls-from-post-data data (+ i 1)))
        []))))

