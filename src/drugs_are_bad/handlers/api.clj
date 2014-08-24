(ns drugs-are-bad.handlers.api
  )

(defn get-time [req]
  {:time (System/currentTimeMillis)
   :req (merge req {:async-channel nil})})
