(ns rna-transcription
    (:require [clojure.string :as s]))

(def nucleotide_pairs {\G \C, \C \G, \T \A, \A, \U})

(defn complement [n]
    (if
        (contains? nucleotide_pairs n)
        (nucleotide_pairs n)
        (throw (AssertionError. "Invalid nucleotide"))
    )
)

(defn to-rna [nucleotides]
  (apply str (map complement nucleotides))
)
