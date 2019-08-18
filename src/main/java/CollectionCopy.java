//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.example.myschema.BankCopyType;
//import com.example.myschema.ClientType;
//import com.example.myschema.ObjectFactory;
//import generated.BankCopyTypePlus;
//import generated.ClientTypePlus;
//import model.Bank;
//import model.Client;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//
//public class CollectionCopy {
//    public static void main(String[] args) {
//        Client client = new Client();
//        client.setINN(111);
//        client.setSNILS("111");
//        client.setPassportNumber("111111");
//
//        Client client1 = new Client();
//        client1.setINN(222);
//        client1.setSNILS("222");
//        client1.setPassportNumber("222222");
//
//        List<Client> clients = new ArrayList<>();
//        clients.add(client);
//        clients.add(client1);
//
//        Bank bank = new Bank();
//        bank.setBik(123123123);
//        bank.setCreateDate(LocalDate.now());
//        bank.setUID("123123123-13123123-123132131");
//        bank.setClients(clients);
//
//        System.out.println(bank);
//
//        BankCopyType bankCopyType = new BankCopyTypePlus();
//        bankCopyType.setUID(bank.getUID());
//
//        bank.getClients()
//            .stream()
//            .forEach(bankClient -> {
//                ClientType clientType = new ClientTypePlus();
//                clientType.setINN(bankClient.getINN());
//                clientType.setPassportNumber(Integer.valueOf(bankClient.getPassportNumber()));
//                clientType.setSNILS((bankClient.getSNILS()));
//
//                bankCopyType.getClients().add(clientType);
//        });
//
//        System.out.println(bankCopyType);
//
//        // TODO: 24.02.2019 Написать тест, что созданный bankCopyType класс соответствует BankCopy xsd-схеме
//
//        try {
//            JAXBContext jc = JAXBContext.newInstance(BankCopyType.class);
//            Marshaller m = jc.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            System.out.println();
//            m.marshal(new ObjectFactory().createBankCopy(bankCopyType), System.out);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
