package Microservice.Billing_Service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Microservice.Billing_Service.Entity.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{

	Optional<Subscriber> findSubscriberBySubscriberNumber(String subscriberNumber);
}
