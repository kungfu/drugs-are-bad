(ns drugs-are-bad.handlers.api
  (:require [clojure.data.json :as json])
  (:require [drugs-are-bad.core :as drugs])
  (:require [drugs-are-bad.jsonhacks :as jsonhacks])
  )

(defn get-time [req]
  {:time (System/currentTimeMillis)
   :req (merge req {:async-channel nil})})

(defn post-burden-with-drugs [req]
  {:result (drugs/burden 
    (Integer. ((:form-params req) "maxWeight"))
    (jsonhacks/hack-get-dolls-from-post-data (:form-params req)))})
