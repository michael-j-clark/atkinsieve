(ns
  atkinsieve.test.wheels.wheels
  (:use clojure.test )
  (:use atkinsieve.wheels.wheels)
  )
(def w1  (->WheelOne 20))
(deftest test-test (is (= 1 1)))

(deftest wheel-one-test
  
  (is (= 80 (calculate w1 2 8))))

(deftest wheel-one-calculate-test
  (let [v1 [143 2 3]] 
  (is (= (map #(+ (* 4 (* %1 %1)) (* %2 %2)) v1 [4 5988 6]) 
         (map #(calculate w1 %1 %2) v1 [4 5988 6])))))

(run-all-tests)