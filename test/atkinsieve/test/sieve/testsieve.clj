(ns
  atkinsieve.test.sieve.testsieve
  (:use atkinsieve.sieve.sieve)
  (:use clojure.test ))


(deftest lte-lim?-test-01
  (let [xv [1 2 3 4 5] limv  [1 2 3 4 5]]
    (is (= (map #(lte-lim? %1 %2) xv limv)
          (take 5 (repeat true))))))

(deftest lte-lim?-test-02
  (let [xv [1 2 3 4 5] limv  [1 10 3 36 5]]
    (is (= (map #(lte-lim? %1 %2) xv limv)
          [true false true false true]))))

(deftest lte-lim?-test-03
  (let [xv [1 2 3 4 5] yv [1 2 3 4 5] limv  [1 10 3 36 5]]
    (is (= (map #(lte-lim? %1 %2 %3) xv yv limv)
          [true false true false true]))))


(run-all-tests)