(ns euler.exercises.17
  (:require [euler.utils :refer [num->num-seq]]))

(let [teen-map {0 "ten"
                1 "eleven"
                2 "twelve"
                3 "thirteen"
                4 "fourteen"
                5 "fifteen"
                6 "sixteen"
                7 "seventeen"
                8 "eighteen"
                9 "nineteen"}
      tens-map {2 "twenty"
                3 "thirty"
                4 "forty"
                5 "fifty"
                6 "sixty"
                7 "seventy"
                8 "eighty"
                9 "ninety"}
      digit-map {1 "one"
                 2 "two"
                 3 "three"
                 4 "four"
                 5 "five"
                 6 "six"
                 7 "seven"
                 8 "eight"
                 9 "nine"}]
  (letfn [(thousand [d] (if (nil? d) nil (str (get digit-map d) "thousand")))
          (hundred [d]
            (cond
              (nil? d) nil
              (zero? d) nil
              :else (str (get digit-map d) "hundred")))
          (ten [a b]
            (cond
              (= a 0) (get digit-map b)
              (= a 1) (get teen-map b)
              :else (clojure.string/trim
                     (str (get tens-map a) (get digit-map b)))))
          (base-map->str [m]
            (let [thousand (thousand (get m 4))
                  hundred (hundred (get m 3))
                  ten (ten (get m 2) (get m 1))]
              (clojure.string/triml
               (str
                thousand
                hundred
                (if (and hundred ten) "and" nil)
                ten))))
          (num->base-map [n]
            (let [n-seq (num->num-seq n)
                  base-seq (reverse (range 1 (inc (count n-seq))))]
              (zipmap base-seq n-seq)))
          (num->word [n]
            (-> n
                num->base-map
                base-map->str))
          (word->count [w]
            (count (seq w)))]
    (let [n 1000
          n-range (range 1 (inc n))
          word-seq (map num->word n-range)
          _ (println (take 1 (drop 341 word-seq)))
          count-seq (map word->count word-seq)
          _ (println (take 1 (drop 341 count-seq)))]
      (reduce + count-seq))))
