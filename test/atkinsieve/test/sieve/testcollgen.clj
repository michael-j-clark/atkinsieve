(ns
  atkinsieve.test.sieve.testcollgen
  (:use clojure.test)
  (:use atkinsieve.sieve.collgen))

(deftest rand-int-vec-test
  (let [n 10 lim 10 v1 (rand-int-vec n lim)]
    (is (= (into [] (take n (repeat true))) (map number? v1)))))


(run-all-tests)