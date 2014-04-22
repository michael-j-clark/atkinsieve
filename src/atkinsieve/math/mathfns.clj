(ns
  atkinsieve.math.math-fns)


(defn square     [x]     (* x x))
(defn multiply   [x y]   (* x y))
(defn plus       [x y]   (+ x y))
(defn n-mod-x-eq [n x y] (true? (== (mod n x ) y)))
