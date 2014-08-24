(ns drugs-are-bad.handlers.api
  (:require [drugs-are-bad.core :as drugs])
  (:require [drugs-are-bad.jsonhacks :as jsonhacks])
  )

(defn post-burden-with-drugs [req]
  {:result (drugs/burden 
    (Integer. ((:form-params req) "maxWeight"))
    (jsonhacks/hack-get-dolls-from-post-data (:form-params req)))})
