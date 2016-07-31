(ns waveform.core
  (:require [org.waveformjs.Waveform]))

(enable-console-print!)

(println "This text is printed from src/waveform/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application

(def w (js/Waveform.
         (clj->js {:container (.getElementById js/document "app")
                   :height 40
                   :width 240
                   :innerColor (fn [x y] (.toString (str "#" (.floor js/Math (* (.random js/Math) 16777215))) 16))
                   :data [0 0.3 1 0.5 1 0.3 0]})))
