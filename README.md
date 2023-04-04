# execution-time-logger
Annotation based logger calculates time taken per method level.
Use it as method level as an annotated interface.

## Available logging options
* @LogExecutionTime
* @LogExecutionTimeExceptionally
* @LogExecutionTimeDebug
* @LogExecutionTimeDebugExceptionally

## Usage:-

* Checkout and maven install locally
* Import the dependency into the required project


        <dependency>
            <groupId>io.jayaprabahar.springboot</groupId>
            <artifactId>execution-time-logger</artifactId>
            <version>1.0.0</version>
        </dependency>

* Add the required annotation


        @LogExecutionTimeExceptionally
    	public void myTestMethod(){
    
    	}
