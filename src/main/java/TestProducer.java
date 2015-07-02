/*
* https://cwiki.apache.org/confluence/display/KAFKA/0.8.0+Producer+Example
*
* */
import java.util.*;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class TestProducer extends  Thread{

    private Thread t;
    //private String threadName;

    private final ProducerConfig config;
    private final  Producer<String, String> producer;
    private final String topic;

    public TestProducer(String topic){

        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "SimplePartitioner");
        props.put("request.required.acks", "1");

         config = new ProducerConfig(props);

         producer = new Producer<String, String>(config);
        //partition key , message
        this.topic=topic;
    }

    public void run() {
        //long events = Long.parseLong("11",10);
        Random rnd = new Random();

        /*http://kafka.apache.org/08/configuration.html
        *"
        * buradaki properties ile producer in clusteri nasılbulacagını gosterir.
        * Properties clası javanın default clasıdır.
        * */


        //burada uydurma bi sekilde hangi tarihde sitenin kim tarafından ziyeret edildiginin bilgisini turuyoruz.
        //for (long nEvents = 0; nEvents < events; nEvents++) {


//        kafkanın looglarını yazdır memesajların ne kadarı alınmıs alımnmamıs loglatttı.
        //bu arada kafkanın ne yaptıgını  bilmeliyim bu sayede 500 in 1291 i ni neden okuyor geri kalanı nerede onu bulayım


           for (int i=0;i<=2500;i++){
               long runtime = new Date().getTime();
               String ip = "192.168.2."+ rnd.nextInt(255);
               String msg = runtime + ",www.example.com," + ip;

               //şimdide broker a message i yazalım.
               KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, ip, msg);
               //"page_visits" parametresi topic dir.yani yazmak istedigimiz topic.
               producer.send(data);
           }

        //}
        producer.close();
    }


    public void start()
    {
        //System.out.println("Starting " +  this.threadName );
        if (t == null)
        {
            t = new Thread (this);
            t.start ();
        }

    }

}