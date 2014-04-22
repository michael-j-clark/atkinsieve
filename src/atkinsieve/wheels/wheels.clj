(ns
  atkinsieve.wheels.wheels
  (:require [clojure.core.match :refer [match]])
  (:use [atkinsieve.math.mathfns]))



(defprotocol WheelFact
  (calculate [this x y])
  (tst [this n]))



(defrecord WheelOne
  [lim]
  WheelFact
  (calculate [this x y]  (plus (multiply 4 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (or (n-mod-x-eq n 12 1)  (n-mod-x-eq n 12 5))))))
	
	
(defn -main []
  (let  [lim 200000 w1  (->WheelOne lim)]
    (prn (map #(tst w1 %1 ) [23 54 75]))))


