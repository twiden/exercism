(ns nucleotide-count)

(def empty {\A 0, \T 0, \C 0, \G 0})

(defn nucleotide-counts [dna]
  (let [sequence (seq dna)]
    (if
      (not (filter (fn [x] (not (empty x))) sequence))
      (throw (AssertionError. "Invalid nucleotide"))
      (merge empty (frequencies sequence)))))

(defn count [nucl dna]
  (if
    (not (empty nucl))
    (throw (AssertionError. "Invalid nucleotide"))
    ((nucleotide-counts dna) nucl)))

