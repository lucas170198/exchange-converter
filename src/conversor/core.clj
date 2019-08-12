(ns conversor.core 
  (:require [conversor.formater :refer [formatar]]
            [conversor.money-changer :refer [obter-cotacao]]
            [conversor.handler-options :refer [interpretar-opcoes]])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
(let [{:keys [de para]} (interpretar-opcoes args)]
  (-> (obter-cotacao de para)
      (formatar de para)
      (prn))))



