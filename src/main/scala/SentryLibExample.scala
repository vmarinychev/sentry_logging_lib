object SentryLibExample extends App {
 val s = SentryLoggingProvider.logger("https://8e0a9ce10c8b4485aaabca945500591f@o4504672845692928.ingest.sentry.io/4504672851787776")
 s.fingerprint("fingerprint")
 s.requestId("requestId")
 s.organization("knoldus")


 s.error("Error message")
 s.debug("Error message")
 s.warning("Error message")
 s.info("Error message")

 val optionInt: Option[Int] = None
 print(optionInt.get + 1)
}
