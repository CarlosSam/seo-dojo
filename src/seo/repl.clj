(ns seo.repl)

; read file
(-> "gloria.txt" slurp)

; split title and contents
(-> "gloria.txt" slurp (.split "\n") ((fn [[e1 _ _ e4]] [e1 e4])))

; dojo
(->> (-> "gloria.txt" slurp (.split "\n") ((fn [[e1 _ _ e4]] [e1 e4])))
  	 (map #(map (fn [c] (cond
  	   						(#{\à \á \ã \â} c) \a
  	   						(#{\é \è \ê \ẽ} c) \e
  	   						(#{\í \ì \ĩ} c) \i
  	   						(#{\ó \ô \õ} c) \o
  	   						(#{\ú \ũ} c) \u
  	   						(Character/isLetterOrDigit c) c
  	   						:else \space))
  	   				%))
  	   (map #(apply str %)))
