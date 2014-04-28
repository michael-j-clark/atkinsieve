(ns
  atkinsieve.sieve.sieve)

(def ^:dynamic coll)
(defn sieve-of-atkin
  "optimized Sieve of Eratosthenes"
  [lim]
  (binding [coll (apply vector (cons 1 (cons 1(take (- lim 2) (repeat false)))))]
    (prn (assoc  coll 3 true))
  ))


(defn -main "main function"
  [& args]
  (sieve-of-atkin (read-string (first args)) )

)