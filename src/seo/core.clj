(ns seo.core
  (:gen-class))

(defn -main
  "SEO reportagem terra"
  [& args]
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
  	   (map #(apply str %))
  	   (map println)
  	   dorun))

; you can simply copy this code on your repl. Don't forget to remove comment (#_)
#_(->> (-> "gloria.txt" slurp (.split "\n") ((fn [[e1 _ _ e4]] [e1 e4])))
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
