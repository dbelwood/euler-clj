(ns euler.exercises.16
  (:require [euler.utils :as utils]))

(let [power 1000
      result (reduce *' (repeat power 2))]
  (reduce + (utils/num->num-seq result)))
