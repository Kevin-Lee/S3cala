S3cala [![Build Status](https://secure.travis-ci.org/Nycto/S3cala.png?branch=master)](http://travis-ci.org/Nycto/S3cala)
======

A non-block S3 client for Scala

Usage
-----

This project is not production ready; use at your own risk.


Get S3cala
----------
In your sbt configuration file (`build.sbt` or `Build.scala`),

```scala
resolvers += "Kevin's Public Repository" at "http://nexus.lckymn.com/content/repositories/kevin-public-releases"

libraryDeps += "com.roundeights" %% "s3cala" % "0.1"
```

Example Usage
-------------

Internally, S3cala is a thin wrapper around the AWS Java SDK. It adapts
the asynchronous API to use Scala's
[Futures](http://docs.scala-lang.org/overviews/core/futures.html), making
it incredibly easy to use.

```scala
package org.example.s3cala

import com.roundeights.s3cala
import import java.io.InputStream

object Main extends App {

    val client = S3("yourAwsAccessKey", "yourAwsSecretKey")

    // "get" returns a Scala Future
    val future = client.bucket("BucketName").get("Key")

    future.onSuccess {
        case stream: InputStream => {
            // Do work with your input stream...

            client.close
        }
    }

    future.onFailure {
        case err: Exception => {
            println( err.getMessage )
            client.close
        }
    }

}
```

License
-------

S3cala is released under the MIT License, which is pretty spiffy. You should
have received a copy of the MIT License along with this program. If not, see
<http://www.opensource.org/licenses/mit-license.php>.

