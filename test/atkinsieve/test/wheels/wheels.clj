(ns
  atkinsieve.test.wheels.wheels
  (:use clojure.test )
  (:use atkinsieve.wheels.wheels))
(def lim 200000)
(def w1  (->WheelOne lim))
(deftest test-test (is (= 1 1)))


(deftest wheel-one-calculate-test
  (let [v1 [143 2 3] v2 [4 5988 6]] 
    (is (= (map #(+ (* 4 (* %1 %1)) (* %2 %2)) v1 v2) 
           (map #(calculate w1 %1 %2) v1 v2)))))
		 
(deftest wheel-one-tst-test
  (let [v1 [143 200 3 234 542235 45 12 86 77]] 
    (is (= (map #(and  (<= % lim) 
	               (or (= (mod %1 12) 1) (= (mod %1 12) 5))) v1) 
           (map #(tst w1 %1 ) v1)))))

(run-all-tests)
