(ns
  atkinsieve.sieve.sieve)


(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (binding [coll (apply vector (cons 1 (cons 1 (take (- lim 2) (repeat false)))))]

  ))
