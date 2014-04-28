(ns
  atkinsieve.sieve.sieve)

(def ^:dynamic coll)
(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (binding [coll (apply vector (cons 1 (cons 1(take (- lim 2) (repeat false)))))]
    ;todo call WheelOne
  ))


(defn -main "main function"
  [& args]
  (sieve-of-atkin (read-string (first args))))