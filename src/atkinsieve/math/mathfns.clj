(ns
  atkinsieve.math.mathfns)


(defn square     [x]     (* x x))
(defn multiply   [x y]   (* x y))
(defn plus       [x y]   (+ x y))
(defn multiply   [x y]   (* x y))
(defn minus      [x y]   (- x y))
(defn n-mod-x-eq [n x y] (true? (== (mod n x ) y)))
