(ns atkinsieve.core
  (:use [atkinsieve.sieve.sieve :only [first-arg sieve-of-atkin]]))
  ;(:require :refer) works in Idea but not w/ lein run ???

(comment
  @param [& args] command line args
  (first args) has to be an integer > 3 )
(defn -main "main function"
  [& args]
  {:pre [(< 3 (-> args (first-arg)))]}
  (let [lim (first-arg args)]
    (-> lim (sieve-of-atkin))))