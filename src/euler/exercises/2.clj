(ns euler.exercises.2
  (:require [euler.utils :as utils]))

 (reduce
  +
  (filter
   even?
   (take-while
    (partial > 4000000)
    utils/fib-seq)))
