/**
 * Created by hduser on 7/1/15.
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {


        TestProducer testProducer = new TestProducer("to8");
        testProducer.start();

/*
        TestConsumer testConsumer = new TestConsumer("to8");
        testConsumer.start();

*/



        // kafkada multi consumer istiyorsan multi partitionun olması gerekiyormuş.
        //to8 5 partitionlu

    }


}
