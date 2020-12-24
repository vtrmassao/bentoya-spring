package com.example.bentoyaspring.services

import com.example.bentoyaspring.dtos.DemandRequest
import com.example.bentoyaspring.dtos.enums.PaymentType
import com.example.bentoyaspring.entities.Customer
import com.example.bentoyaspring.entities.Demand
import com.example.bentoyaspring.entities.Product
import com.example.bentoyaspring.entities.Stock
import com.example.bentoyaspring.repositories.CustomerRepository
import com.example.bentoyaspring.repositories.DemandRepository
import com.example.bentoyaspring.repositories.StockRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import javax.transaction.Transactional

@Transactional
@Service
class DemandServiceImpl
@Autowired constructor(private val demandRepository: DemandRepository,
                       private val customerRepository: CustomerRepository,
                       private val stockRepository: StockRepository) : DemandService {
    override fun save(demand: List<DemandRequest>) {
        demand.forEach {
            val customer = customerRepository.findCustomerByPhone(it.phone)

            val products = it.products.map { prod ->
                val stock = stockRepository.findStockById(prod.item)

                stock?.let { stk ->
                    stockRepository.save(Stock(stk.id, stk.quantity?.minus(prod.quantity), stk.value))
                    Product(stk, prod.quantity)
                }
            }

            var newDemand: Demand

            newDemand = if (customer != null) {
                Demand(PaymentType.valueOf(it.paymentType), products, customer)
            } else {
                Demand(PaymentType.valueOf(it.paymentType), products, Customer(it.name, it.phone))
            }
            demandRepository.save(newDemand)
        }
    }
}