(ns euler.exercises.9
  (:require [euler.utils :as utils]))

;; Procedure comes from here - http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Pythag/pythag.html#section2.4
(letfn [(mn-seq-fn [max-m]
          (filter (fn [[m n]] (> m n))
                  (for [m (range 1 (inc max-m)) n (range 1 max-m)]
                    (vector m n))))
        (mn->triple-seq [mn-seq]
          (map
           (fn [[m n]] {
                        :a (- (* m m) (* n n))
                        :b (* 2 (* m n))
                        :c (+ (* m m) (* n n))
                        }
             )
           mn-seq))
        (triple-sum [t] (+ (:a t) (:b t) (:c t)))
        (triple-product [t] (* (:a t) (:b t) (:c t)))
        (result [t s p] {:sum s :product p})]
  (let [mn-seq (mn-seq-fn 20)
        triple-seq (mn->triple-seq mn-seq)
        triple-sum-seq (map triple-sum triple-seq)
        triple-prod-seq (map triple-product triple-seq)]
    (take 200 (map result triple-seq triple-sum-seq triple-prod-seq))))
