(ns euler.exercises.10
  (:require [euler.utils :as utils]))

(let [prime-ceil 2000000]
  (reduce + (take-while (partial > prime-ceil) utils/prime-seq)))
