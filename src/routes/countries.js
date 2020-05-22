import { Router } from 'express';

const router = Router();

router.get('/', (req, res) => {
  return res.send(Object.values(req.context.models.countries));
});

router.get('/:id', (req, res) => {
  return res.send(req.context.models.countries[req.params.id]);
});

export default router;
