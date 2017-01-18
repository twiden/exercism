(ns word-count
    (:require [clojure.string :as s]))

(defn- count-words [state word]
    (assoc state word (+ (get state word 0) 1)))

(defn word-count [phrase]
    (reduce count-words {} (s/split (s/lower-case phrase) #"\W+"))
)
