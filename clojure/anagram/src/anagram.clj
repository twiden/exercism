(ns anagram
    (:require [clojure.string :as s]))


(defn anagram? [w1 w2]
    (if (and (not (= (s/lower-case w1) (s/lower-case w2))) (= (sort (s/split (s/lower-case w1) #"")) (sort (s/split (s/lower-case w2) #"")))) w2 nil)
)

(defn anagrams-for [phrase, anagrams]
    (keep (partial anagram? phrase) anagrams)
)
