(ns
  atkinsieve.wheels.wheels
  (:require [clojure.core.match :refer [match]])
  (:use [atkinsieve.math.mathfns]))


(defprotocol WheelFact
  (calculate [this x y])
  (tst [this n])
  (factor [this x y coll])
  )

(defn flipwheel
  ;"toggle boolean value"
  [n coll]
  (if (get coll (dec n))
    (assoc coll (int (dec n)) false)
    (assoc coll (int (dec n)) true)))

(defrecord WheelThree
  [lim]
  WheelFact
  (calculate [this x y]  (cond (> x y) (minus (multiply 3 (square x)) (square y) ) :else (inc lim)))
  (tst
    [this n]
    (true? (and (<= n lim) (n-mod-x-eq n 12 11) )))
  (factor [this x y coll]
    (let [ n3 (calculate this x y) ]
      (prn coll "in WheelThree->factor")
      (if (tst this n3)
        (flipwheel n3 coll)
        coll
      ))))


(defrecord WheelTwo
  [lim]
  WheelFact
  (calculate [this x y]  (plus (multiply 3 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (n-mod-x-eq n 12 7))))
  (factor [this x y coll]
    (let [ n2 (calculate this x y) ]
      (prn coll "in WheelTwo->factor")
      (if (tst this n2)
        (factor (->WheelThree lim) x y (flipwheel n2 coll))
        (factor (->WheelThree lim) x y coll))) ))


(defrecord WheelOne
  [lim]
  WheelFact
  (calculate [this x y]  (plus (multiply 4 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (or (n-mod-x-eq n 12 1)  (n-mod-x-eq n 12 5)))))
  (factor [this x y coll]
    (let [ n1 (calculate this x y) ]
      (prn coll "in WheelOne->factor")
      (if (tst this n1)
        (factor (->WheelTwo lim)  x y (flipwheel n1 coll))
        (factor (->WheelTwo lim)  x y  coll)))))





	


