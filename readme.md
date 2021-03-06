- [TL;DR](#sec-1)
- [Status](#sec-2)
  - [Feature list](#sec-2-1)
- [Why symbolic? - there's something missing](#sec-3)
- [Concepts](#sec-4)
  - [Quantum states](#sec-4-1)
- [FAQ](#sec-5)
  - [What's in a name?](#sec-5-1)
  - [Scope](#sec-5-2)
  - [Alternatives](#sec-5-3)
    - [Symbolic](#sec-5-3-1)
    - [Numerical](#sec-5-3-2)


# TL;DR<a id="sec-1"></a>

Measurement (quantum) mechanics for the clojure-aware.

If you want to be able to solve, simulate and visualise quantum phenomena without leaving your computer, this is the library for you.

# Status<a id="sec-2"></a>

Nothing has been implemented at all!

## Feature list<a id="sec-2-1"></a>

| Modelling Feature                                  | Realised |
|-------------------------------------------------- |-------- |
| normal vector state (kets and bras)                | ✗        |
| inner product                                      | ✗        |
| outer product                                      | ✗        |
| Tensor product                                     | ✗        |
| Hermitian operator                                 | ✗        |
| coherent state                                     | ✗        |
| number state                                       | ✗        |
| state solving (*e.g.* Lindblad equations)          | ✗        |
| shortcuts for common field and atomic calculations | ✗        |
| abstract Dirac manipulation                        | ✗        |

| Implementation Feature         | Realised |
|------------------------------ |-------- |
| free                           | ✓        |
| open-source                    | ✓        |
| extensible                     | ✓        |
| runs on JVM                    | ✓        |
| runs in browser                | ✗        |
| parallelisable equation solver | ✗        |
| exports to LaTeX               | ✗        |
| exports to MathJax             | ✗        |
| better than Mathematica!       | ✗        |

# Why symbolic? - there's something missing<a id="sec-3"></a>

It should be a frustration in physics that there is so much friction between symbolic manipulation, computation, and the crystalization of ideas.

This problem expresses itself in many ways but at it's most basic can be seen in how it is still common practise to wade through algebra with pen and paper before then re-writing exactly the same thing programmatically to explore the consequences. Even this is an idealization, with the practice more likely to be a constant dance between the two or, even worse, for symbolic manipulation and numerical calculation to be joined with an exclusive OR.

Another practical example of this problem is how there still(!) doesn't seem to be a standard language for representing mathematics computationally. And by computationally here, I mean a way in which the concepts and relationships can be written independently from typography and programming language. LaTeX has beeen a powerful tool in the technical sciences but even aside from showing its age, it is a typesetting system, not a mathematics DSL.

I do not pretend that these problems are not difficult, particularly the second one, but I find it strange that so little priority has been given to these tasks. Have no fear though, there is hope! Although the problem is old, the solution might be too. It's time to consider a formulation of mathematics just as foundational as sets. It's name is *lambda calculus* but its friends call it LISP :).

# Concepts<a id="sec-4"></a>

## Quantum states<a id="sec-4-1"></a>

An invaluable framework for working with quantum systems is the Dirac formalism for describing quantum states. To be competitive with pen and paper (if not pencil&#x2026;), a symbolic quantum algebra system should be able to approach this elegance.

To illustrate the basic operations we need, let's consider some examples. This is not an introduction to quantum mechanics, but by summarizing the basics we can discover the range of symbolic operations needed to be able to do useful work.

Working in a lab, useful means experiment, experiment means measurement and measurement means something to measure. The something to measure is called the *state*. The state of a quantum system is represented by a ket, $`|\psi\rangle`$, where $`\psi`$ is a label for the system. The label can be used purely as an ID but often it plays an active role in calculations, even changing in response to operators. For our purposes it's enough to know that, in principle, the ket contains complete knowledge of the system. Interestingly, often more than we can ever measure.

Mathematically, the ket is an infinite-dimensional vector space, known as a Hilbert space. Naturally, this makes it interesting (in the British sense) to represent in software. For many practical situations it is enough to treat a ket as simply a finite-length column vector. I think however, that there is value in holding-on to the abstraction as long as possible.

At some point however, we will need to make predictions and this means numbers. To get numbers from kets, we can combine the ket with its dual. The dual represents the conjugate transpose of the ket and is drawn similarly: $`\langle\psi|`$. Combining the *bra* and *ket* together like so, $`\langle\psi|\psi\rangle`$, results in a number, and this operation is known as the *inner product*.

To query the system, we apply an operator, $`\hat{O}`$, such that $`\hat{O} |\psi\rangle = o |\psi\rangle`$, and $`o`$ is a complex number. An operator itself can also be made from combining bras and kets with the outer product *i.e.* $`|\psi\rangle\langle\psi|`$.

Operators and kets generally operate within their own Hilbert space. To consider bigger systems however we need to be able to extend our space and we do this with tensor products. This can be represented with the product of kets. And so, the different products that we need, to begin with, can be summarized as below.
```math
\newcommand{\ham}{\hat{H}_{0}}
\gdef\ket#1{|#1\rangle} 
\gdef\bra#1{\langle #1 |} 
\gdef\ketbra#1{|#1\rangle\langle #1 |} 
\begin{aligned}
\ket{\Psi} &= a\ket{1}\\
  \bra{\Psi}\ket{\Psi} &= a^{*}a\text{     (Inner product)} \\
  \ket{\Psi}\bra{\Psi} &= a^{*}a\ketbra{1} \text{     (Outer product)}\\
\ket{1 0} \otimes \ket{1 0} &= \ket{1 0 1 0} \text{     (Tensor product)}
\end{aligned}
```

# FAQ<a id="sec-5"></a>

## What's in a name?<a id="sec-5-1"></a>

I only put a few minutes thought into it but my impression is that quantum mechanics is a misleading name. Although there are rational reasons for the word quantum, particularly historically, the framework applies to continuous fields as well. Also, I don't think the discreteness or smallness of the natural lengthscales are really the main thing. The two most interesting (read *incredible*) things about quantum mechanics are the effects of measurement and non-locality (entanglement).

I particularly like the idea of how quantum mechanics suggests that the underlying reality (wavefunction) is not something that we can ever fully experience (measure) but rather that when considering the great cathedrals of the natural world, we only stand at the door and peek through the keyhole.

It also seems to be the case that every great result in physics these days can be reduced to a peak.

## Scope<a id="sec-5-2"></a>

Fully quantum and semiclassical systems, with an emphasis on light-matter interaction.

## Alternatives<a id="sec-5-3"></a>

### Symbolic<a id="sec-5-3-1"></a>

1.  Wolfram Language (Mathematica)

    Specifically, the [atomic density matrix](http://rochesterscientific.com/ADM/) package for working with semiclassical light-matter interaction.
    
    1.  Pros
    
        -   Probably the most advanced computer algebra system in the world. Certainly far more (30 years commercial) development than this little library.
        -   free access to the Wolfram engine
        -   Tries to be comprehensive across many aspects of computing
    
    2.  Cons
    
        -   Expensively proprietary
            -   all the usual problems from this. Including (but not limited to) restricted access to hobbyists, vendor lock-in and inflexibility.
        -   Mathematica tries to emulate *pencil and paper*-style maths rather than trying to out-do it.
        -   doesn't feel like a *real* language for general production. Though some people have proved me wrong.
        -   Not particularly well suited to quantum operations.

### Numerical<a id="sec-5-3-2"></a>

1.  QuTip

    A python toolbox for open quantum systems: [QuTiP](http://qutip.org/).

2.  C++QED

    A C++ framework for simulating open quantum dynamics: [C++QED](http://cppqed.sourceforge.net/cppqed/html/index.html).
