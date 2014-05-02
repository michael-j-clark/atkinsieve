(ns
  atkinsieve.wheels.wheels
  (:require [clojure.core.match :refer [match]])
  (:use [atkinsieve.math.mathfns])
  (:use atkinsieve.sieve.collgen))


(defprotocol WheelFact
  (calculate [this x y])
  (tst [this n])
  (factor [this x y])
  )

(defn- flipwheel
  "toggle boolean value"
  [n coll]
  (if (get coll (dec n))
    (assoc coll (int (dec n)) false)
    (assoc coll (int (dec n)) true)))

(defrecord WheelThree
  [lim coll]
  WheelFact
  (calculate [this x y]  (cond (> x y) (minus (multiply 3 (square x)) (square y) ) :else (inc lim)))
  (tst
    [this n]
    (true? (and (<= n lim) (n-mod-x-eq n 12 11) )))
  (factor [this x y]
    (let [ n3 (calculate this x y) ]
      (if (tst this n3)
        (flipwheel n3 coll)
        coll))))


(defrecord WheelTwo
  [lim coll]
  WheelFact
  (calculate [this x y]  (plus (multiply 3 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (n-mod-x-eq n 12 7))))
  (factor [this  x y]
    (let [ n2 (calculate this x y) ]
      (if (tst this n2)
        (factor (->WheelThree lim  (flipwheel n2 coll)) x y)
        (factor (->WheelThree lim  coll) x y))) ))


(defrecord WheelOne
  [lim coll]
  WheelFact
  (calculate [this x y]  (plus (multiply 4 (square x)) (square y) ))
  (tst
    [this n]
    (true? (and (<= n lim) (or (n-mod-x-eq n 12 1)  (n-mod-x-eq n 12 5)))))
  (factor [this  x y]
    (let [ n1 (calculate this x y) ]
      (if (tst this n1)
        (factor (WheelTwo. lim  (flipwheel n1 coll))  x y)
        (factor (->WheelTwo lim  coll)  x y)))))





	


