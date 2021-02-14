(TeX-add-style-hook
 "slackmessage"
 (lambda ()
   (TeX-run-style-hooks
    "latex2e"
    "article"
    "art10"
    "physics")
   (LaTeX-add-labels
    "eq:2"
    "eq:1"))
 :latex)

