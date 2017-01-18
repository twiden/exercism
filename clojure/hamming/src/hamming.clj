(ns hamming
    (:require [clojure.string :as s]))


(defn distance [a b]
    (if (= (count a) (count b)) (reduce + (map (fn [x] (if (apply not= x) 1 0))(map vector a b))))
)
