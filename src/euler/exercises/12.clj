(ns euler.exercises.12
  (:require [euler.utils :refer [number-of-factors]]))

(letfn [(triangle-num [n] (* n (/ (+ n 1) 2)))]
  (let [triangle-seq (map triangle-num (iterate inc 1))]
    (first (drop-while #(< (number-of-factors %) 500) triangle-seq))))
