(defproject atkinsieve "1.0.0-SNAPSHOT"
  :description "Sieve of Atkin"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.match "0.2.1"]
                 [org.clojure/core.typed "0.2.44"]]
  ;:plugins [[lein-typed "0.3.4"]]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  ;:test-paths ["test" "test/atkinsieve/test/math"]
  :main atkinsieve.core)