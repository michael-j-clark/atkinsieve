(ns
  atkinsieve.sieve.collgen)

 ;Had this is sieve.sieve but there was cyclic dependency error bec. is needed in wheels.wheels
(defn gen-coll "make the collection, a boolean vector w/ first two elems true" [lim]
  (apply vector (cons true (cons true (take (- lim 2) (repeat false))))))
