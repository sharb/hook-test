// src/org/foo/Zot.groovy
package org.foo;

def checkOutFrom(repo) {
  git url: "git@github.com:jenkinsci/${repo}"
}

return this
