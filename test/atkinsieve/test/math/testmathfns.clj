(ns
  atkinsieve.test.math.testmathfns
  (:use clojure.test)
  (:use atkinsieve.math.mathfns))

(deftest squares-test
  (let [r 123]
    (is (= (->>  (range r) (map #(*  % %))) (->> (range r) (map square))))))

(deftest multiply-test
  (let [q 32289 r 5]
    (is (= (->> (range r) (map #(multiply % q))) (->> (range r) (map #(* % q)))))))

(deftest minus-test
  (let [q 32289 r 5]
    (is (= (->> (range r) (map #(minus % q))) (->> (range r) (map #(- % q)))))))

(deftest plus-test
  (let [q 1763129 r 5]
    (is (= (->> (range r) (map #(plus % q))) (->> (range r) (map #(+ % q) ))))))

(run-all-tests)