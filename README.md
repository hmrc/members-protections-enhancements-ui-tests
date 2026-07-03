# members-protections-enhancements-ui-tests

## Overview

This is the journey(ui/acceptance) test repository for members protections enhancements

## Starting Services

To start the required services, run:
```shell 
sm2 --start MPE_ALL
```

## Executing tests

### Running UI tests locally

```bash
./run-tests.sh
```

### Running UI tests in QA

```bash
./run-tests-qa.sh
```

Note that often the QA downstream may be switched off, so it is advised to test locally

### ZAP tests

```bash
./run-zap-tests.sh
```

Note that often the QA downstream may be switched off, so it is advised to test locally

## Licence

This code is open source software licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).

