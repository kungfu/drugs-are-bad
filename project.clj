(defproject drugs-are-bad "0.1.0-SNAPSHOT"
  :description "A response to: Use Clojure to Move Drugs: A Programming Challenge (https://github.com/micahalles/doll-smuggler)"
  :url "https://github.com/kungfu/drugs-are-bad"
  :license {:name "WTFPL"
            :url "http://www.wtfpl.net"}
  :main drugs-are-bad.main
  :aot [drugs-are-bad.main]
  :uberjar-name "drugs-are-bad-standalone.jar"
  ;; :plugins [[lein-swank "1.4.4"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.2"]
                 [compojure "1.1.5"]
                 [ring/ring-core "1.1.8"]

                 [org.clojure/data.json "0.2.5"]

                 [http-kit "2.1.16"]

                 [http-kit/dbcp "0.1.0"] ;; database access

                 [mysql/mysql-connector-java "5.1.21"] ;; mysql jdbc driver

                 ;; [org.fressian/fressian "0.6.3"]

                 ;; for serialization clojure object to bytes
                 ;; [com.taoensso/nippy "1.1.0"]

                 ;; Redis client & message queue
                 ;; [com.taoensso/carmine "1.5.0"]

                 ;; logging,  another option [com.taoensso/timbre "1.5.2"]
                 [org.clojure/tools.logging "0.2.6"]
                 [ch.qos.logback/logback-classic "1.0.1"]
                 ;; template
                 [me.shenfeng/mustache "1.1"]])
