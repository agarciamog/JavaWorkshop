package io.albertogarcia.javaWorkshop;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HelpDesk {
    private final LinkedList<Enquiry> enquiries = new LinkedList<>();

    public void enquire(final Customer customer, final Category category) {
        enquiries.add(new Enquiry(customer, category));
    }

    public void processAllEnquiries() {
        Enquiry enquiry;
        while(!enquiries.isEmpty()) {
            enquiry = enquiries.remove();
            enquiry.getCustomer().reply("restart it!");
        }
    }

    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processAllEnquiries();
    }
}

